package com.javafollower.basic.enumdemo;

public enum Status {
    OFFERINST(Inst.OfferInst.class);

    Status(Class<? extends Inst> kind) {
        //通过class对象获取枚举实例
        Inst[] values = kind.getEnumConstants();
    }

    public interface Inst {
        String getCode();
        String getDesc();

        enum OfferInst implements Inst {
            EFF("1000", "生效"),
            EXP("1100", "失效"),
            PRE("1200", "预生效"),
            CANCEL("1300", "撤单"),;

            private String code;
            private String desc;
            OfferInst(String code, String desc) {
                this.code = code;
                this.desc = desc;
            }

            @Override
            public String getCode() {
                return code;
            }

            @Override
            public String getDesc() {
                return desc;
            }
        }



    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Status status = Enums.random(Status.class);
            System.out.println(status);
        }
    }

}

