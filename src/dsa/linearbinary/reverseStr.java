package linearbinary;

class reverseStr {

    static String rev(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(rev(s));
    }
}
