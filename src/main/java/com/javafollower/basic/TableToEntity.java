package com.javafollower.basic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.javafollower.utils.CommonUtils.ToggleCase.TO_UPPER_CASE;
import static com.javafollower.utils.CommonUtils.humpString;
import static com.javafollower.utils.CommonUtils.toggleCaseFirstLetter;


/**
 * 根据表生成Entity文件
 * <p>
 * 修改test_Table()方法中的参数值，即可执行main方法获得想要的结果
 * <p>
 * 生成文件后导入需要的包
 * 依赖包：mysql数据库驱动包
 * 生成其他数据库类型的表需要更换驱动类并略做数据类型转换的修改即可
 * <p>
 * 注意：数据库数据类型只包括了常用的几种，其他数据类型还需要在完善，请添加‘ftype’该数组变量的值
 */
public class TableToEntity {

    private static String[][] propertyTypeMatrix = new String[][]{{"tinyint unsigned", "Integer"},
            {"tinyint", "Integer"}, {"int unsigned", "Integer"}, {"int", "Integer"},
            {"smallint unsigned", "Integer"}, {"smallint", "Integer"},
            {"varchar", "String"}, {"char", "String"}, {"longtext", "String"},
            {"text", "String"}, {"decimal unsigned", "BigDecimal"},
            {"decimal", "BigDecimal"}, {"datetime", "String"}, {"date", "String"},
            {"timestamp", "String"}, {"unsigned", ""}};

    public static void main(String[] args) {
        test_Table();
    }

    /**
     * 设置参数--需要修改
     */
    public static void test_Table() {
        String tableName = "special_list";//需要转换的表
        String host = "127.0.0.1";//数据库host
        String port = "32769";//数据库端口
        String database = "cust_center";//数据库名
        String username = "root";//数据库用户名
        String password = "123456";//数据库用密码
        String path = "/Users/lixin/Downloads/Complete";//生成文件存放目录，不包括文件名，文件名自动命名为 '表名.java,表名Mapper.xml,表名Dao.java'
        // 首字母大写
        String daoPackage = "com.tydic.dao.";//dao的包路径
        String entityPackage = "com.tydic.entity.";//entity的包路径
        //生成entity文件
        getTableToEntityFile(tableName, host, port, database, username, password, entityPackage, path);
        //生成ResultMap文件
        getTableToResultMap(tableName, host, port, database, username, password, daoPackage, entityPackage, path);
        //生成Dao文件
        getResultMapToDao(tableName, daoPackage, entityPackage, path);
    }

    /**
     * 根据表生成Entity文件
     */
    public static void getTableToEntityFile(String tableName, String host, String port, String database,
                                            String user, String password, String entityPackage, String path) {

        String url = "jdbc:mysql://" + host + ":" + port + "/" + database
                + "?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";
        //需要替换的数据类型，待完善


        //如果包路径是以“.”结尾的要去掉
        entityPackage = entityPackage == null ? "" : entityPackage;
        entityPackage = entityPackage.length() > 0 && entityPackage.endsWith(".") ?
                entityPackage.substring(0, entityPackage.length() - 1) : entityPackage;

        System.out.println("==============================");
        System.out.println("正在生成。。。");
        String querySql = "SELECT * FROM " + tableName + " limit 0";
        List<Map<String, String>> columnList = queryFieldList(querySql, url, user, password);

        String classStart = "package "
                + entityPackage
                + ";\n\nimport java.io.Serializable;\nimport java.math.BigDecimal;\n\npublic class #tablename# " +
                "implements Serializable {\n";
        String classEnd = "}";

        StringBuilder classPro = new StringBuilder();//类拼接
        if (columnList.size() > 0) {
            for (Map<String, String> columnMap : columnList) {
                for (Map.Entry<String, String> entry : columnMap.entrySet()) {
                    classPro.append(createPropertyClass(entry));
                }
            }
        }

        tableName = toggleCaseFirstLetter(humpString(tableName, "_"), TO_UPPER_CASE);

        //添加方法头
        classPro.insert(0, classStart.replace("#tablename#", tableName));
        //添加方法尾
        classPro.append(classEnd);

        System.out.println("==============================");
        //生成文件名及保存路径
        path = path + tableName + ".java";
        //写文件
        write(classPro.toString(), path);

        System.out.println("javabean文件已生成，请查看：" + path);
    }

    private static String createPropertyClass(Map.Entry<String, String> entry) {
        String property = "\tprivate #propertyType# #propertyName#;\n";
        String getMethod = "\tpublic #propertyType# get#methodPropertyName#() {\n\t\treturn #propertyName#;\n\t}\n";
        String setMethod = "\tpublic void set#methodPropertyName#(#propertyType# #propertyName#) {\n"
                + "\t\tthis.#propertyName# = #propertyName#;\n\t}\n";

        String fieldName = entry.getKey();
        String fieldType = entry.getValue().toLowerCase();

        //替换数据类型
        String propertyType = getPropertyType(fieldType);
        String propertyName = humpString(fieldName, "_");
        String methodPropertyName = toggleCaseFirstLetter(propertyName, TO_UPPER_CASE);

        return "\n" +
                property.replace("#propertyType#", propertyType)
                        .replace("#propertyName#", propertyName) +
                "\n" +
                getMethod.replace("#propertyType#", propertyType)
                        .replace("#methodPropertyName#", methodPropertyName)
                        .replace("#propertyName#", propertyName) +
                "\n" +
                setMethod.replace("#propertyType#", propertyType)
                        .replace("#methodPropertyName#", methodPropertyName)
                        .replace("#propertyName#", propertyName);
    }

    private static String getPropertyType(String propertyType) {
        for (String[] propertyTypeArray : propertyTypeMatrix) {
            propertyType = propertyType.replace(propertyTypeArray[0], propertyTypeArray[1]);
        }
        return propertyType;
    }

    /**
     * 根据表生成resultMap配置，及select,insert,update全配置
     */
    public static void getTableToResultMap(String tableName, String host, String port, String database, String user,
                                           String password, String daoPackage, String entityPackage, String path) {

        String url = "jdbc:mysql://" + host + ":" + port + "/" + database
                + "?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";

        System.out.println("==============================");
        System.out.println("正在生成。。。");
        String sql = "SELECT * FROM " + tableName + " limit 0";
        List<Map<String, String>> fieldList = queryFieldList(sql, url, user, password);

        //如果包路径不是以“.”结尾的要补齐
        daoPackage = daoPackage == null ? "" : daoPackage;
        daoPackage = daoPackage.length() > 0 && !daoPackage.endsWith(".") ? daoPackage + "." : daoPackage;
        entityPackage = entityPackage == null ? "" : entityPackage;
        entityPackage = entityPackage.length() > 0 && !entityPackage.endsWith(".") ? entityPackage + "." : entityPackage;
        //模板字符串
        String fieldToProperty = "\t\t<result property=\"#propertyName#\" column=\"#fieldName#\" />\n";

        String mapStart = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD" +
                " Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n<mapper namespace=\""
                + daoPackage + "#upperTableName#Dao\">\n\n";
        String mapend = "</mapper>";

        String resultStart = "\t<resultMap id=\"#lowerTableName#Result\" type=\""
                + entityPackage + "#upperTableName#\">\n";
        String resultEnd = "\t</resultMap>\n\n";

        String selectStart = "\t<select id=\"get\" resultMap=\"#lowerTableName#Result\">\n";
        String selectEnd = "\t</select>\n\n";

        String insertStart = "\t<insert id=\"insert\" parameterType=\"" + entityPackage + "#upperTableName#\">\n";
        String insertEnd = "\t</insert>\n\n";

        String updateStart = "\t<update id=\"update\" parameterType=\"" + entityPackage + "#upperTableName#\">\n";
        String updateEnd = "\t</update>\n\n";

        StringBuilder resultMap = new StringBuilder();//字段拼接
        StringBuilder selectField = new StringBuilder();//select拼接
        StringBuilder insertField = new StringBuilder();//insert拼接
        StringBuilder insertValue = new StringBuilder();//insert value拼接
        StringBuilder updateSet = new StringBuilder();//update set拼接
        if (fieldList.size() > 0) {
            for (Map<String, String> fieldMap : fieldList) {
                for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
                    String fieldName = entry.getKey();
                    String propertyName = humpString(fieldName, "_");

                    resultMap.append(fieldToProperty.replace("#propertyName#", propertyName)
                            .replace("#fieldName#", fieldName));

                    selectField.append("`").append(fieldName).append("`,");
                    insertField.append("`").append(fieldName).append("`,");
                    insertValue.append("#{").append(propertyName).append("},");
                    updateSet.append("`").append(fieldName).append("`= #{").append(propertyName).append("},");
                }
            }
        }

        String lowerTableName = humpString(tableName, "_");
        String upperTableName = toggleCaseFirstLetter(lowerTableName, TO_UPPER_CASE);

        resultMap.insert(0, resultStart.replace("#upperTableName#", upperTableName));
        resultMap.append(resultEnd);
        if (selectField.toString().endsWith(",")) {
            selectField = new StringBuilder(selectField.substring(0, selectField.length() - ",".length()));
        }
        if (insertField.toString().endsWith(",")) {
            insertField = new StringBuilder(insertField.substring(0, insertField.length() - ",".length()));
        }
        if (insertValue.toString().endsWith(",")) {
            insertValue = new StringBuilder(insertValue.substring(0, insertValue.length() - ",".length()));
        }
        if (updateSet.toString().endsWith(",")) {
            updateSet = new StringBuilder(updateSet.substring(0, updateSet.length() - ",".length()));
        }

        //拼接sql语句
        String select = "\t\tselect " + selectField + " from " + tableName + "\n";
        String insert = "\t\tinsert into " + tableName + "(" + insertField + ")values("
                + insertValue + ")" + "\n";
        String update = "\t\tupdate " + tableName + " set " + updateSet + "\n";

        //生成select语句的Map配置
        String selectMap = selectStart + select + selectEnd;
        //生成insert语句的Map配置
        String insertMap = insertStart + insert + insertEnd;
        //生成update语句的Map配置
        String updateMap = updateStart + update + updateEnd;
        //各个Map配置组合
        resultMap.append(selectMap).append(insertMap).append(updateMap);
        //添加Map文件的头和尾
        resultMap = new StringBuilder(mapStart + resultMap + mapend);

        resultMap = new StringBuilder(resultMap.toString().replace("#upperTableName#", upperTableName));
        resultMap = new StringBuilder(resultMap.toString().replace("#lowerTableName#", lowerTableName));

        //生成文件名及保存路径
        System.out.println("==============================");
        path = path + upperTableName + "Mapper.xml";

        //写文件
        write(resultMap.toString(), path);
        System.out.println("Map文件已生成，请查看：" + path);
    }

    /**
     * 根据resultMap生成Dao文件
     */
    public static void getResultMapToDao(String tableName, String daoPackage,String entityPackage, String path) {

        System.out.println("==============================");
        System.out.println("正在生成。。。");

        //如果包路径是以“.”结尾的要去掉
        daoPackage = daoPackage == null ? "" : daoPackage;
        daoPackage = daoPackage.length() > 0 && daoPackage.endsWith(".") ?
                daoPackage.substring(0, daoPackage.length() - 1) : daoPackage;
        //如果包路径不是以“.”结尾的要补齐
        entityPackage = entityPackage == null ? "" : entityPackage;
        entityPackage = entityPackage.length() > 0 && !entityPackage.endsWith(".") ? entityPackage + "." : entityPackage;

        //模板字符串
        String lowerTableName = humpString(tableName, "_");
        String upperTableName = toggleCaseFirstLetter(lowerTableName, TO_UPPER_CASE);

        String daoStart = "package " + daoPackage + ";\n\nimport " + entityPackage + upperTableName
                + ";\n\npublic interface #upperTableName#Dao {\n\n";
        String daoEnd = "}";
        String get = "\t#upperTableName# get(Integer id);\n\n";
        String insert = "\tint insert(#upperTableName# #lowerTableName#);\n\n";
        String update = "\tint update(#upperTableName# #lowerTableName#);\n\n";

        String classstr = "";
        classstr = classstr + get.replace("#upperTableName#", upperTableName);
        classstr = classstr + insert.replace("#upperTableName#", upperTableName)
                .replace("#lowerTableName#", lowerTableName);

        classstr = classstr + update.replace("#upperTableName#", upperTableName)
                .replace("#lowerTableName#", lowerTableName);

        classstr = daoStart.replace("#upperTableName#", upperTableName) + classstr + daoEnd;

        //生成文件名及保存路径

        System.out.println("==============================");
        path = path + upperTableName + "Dao.java";
        //写文件
        write(classstr, path);
        System.out.println("Dao文件已生成，请查看：" + path);
    }

    /**
     * 查询表的元数据信息
     */
    public static List<Map<String, String>> queryFieldList(String querySql, String url, String user, String password) {

        List<Map<String, String>> resultList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(querySql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                Map<String, String> map = new HashMap<>();
                map.put(metaData.getColumnName(i), metaData.getColumnTypeName(i));
                resultList.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultList;
    }

    /**
     * 生成文件
     */
    private static void write(String str, String path) {
        FileWriter fw = null;
        PrintWriter out = null;
        try {
            File file = new File(path);
            fw = new FileWriter(file, false);
            out = new PrintWriter(fw);
            out.print(str);
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection(String url, String user, String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
