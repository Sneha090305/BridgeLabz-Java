package linearbinary;

class concatStr {

    static String join(String[] a) {
        StringBuffer sb = new StringBuffer();
        for (String s : a)
            sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] a = {"Java", " ", "is", " ", "powerful"};
        System.out.println(join(a));
    }
}
