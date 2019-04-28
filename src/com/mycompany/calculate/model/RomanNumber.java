package com.mycompany.calculate.model;

public enum RomanNumber {

    I {
        @Override
        public Integer getArabNumber() { return 1;}
    },

    II{
        @Override
        public Integer getArabNumber() { return 2;}
    },

    III{
        @Override
        public Integer getArabNumber() { return 3;}
    },

    IV{
        @Override
        public Integer getArabNumber() { return 4;}
    },

    V{
        @Override
        public Integer getArabNumber() { return 5;}
    },

    VI{
        @Override
        public Integer getArabNumber() { return 6;}
    },

    VII{
        @Override
        public Integer getArabNumber() { return 7;}
    },

    VIII{
        @Override
        public Integer getArabNumber() { return 8;}
    },

    IX{
        @Override
        public Integer getArabNumber() { return 9;}
    },

    X{
        @Override
        public Integer getArabNumber() { return 10;}
    };

    public abstract Integer getArabNumber();
}
