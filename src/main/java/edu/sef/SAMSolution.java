package edu.sef;

@FunctionalInterface
interface SAM {
    String method();
}

class SAMSolution {
    public static void main(String[] args) {
        SAM samObj = new SAM() {
            @Override
            public String method() {
                return "null";
            }
        };

        System.out.println(samObj.method());
    }
}
