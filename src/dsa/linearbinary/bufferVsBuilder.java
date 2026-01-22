package linearbinary;

class bufferVsBuilder {

    static void testBuffer(int n) {
        StringBuffer sb = new StringBuffer();
        long st = System.nanoTime();
        for (int i = 0; i < n; i++)
            sb.append("hello");
        long et = System.nanoTime();
        System.out.println("StringBuffer time: " + (et - st));
    }

    static void testBuilder(int n) {
        StringBuilder sb = new StringBuilder();
        long st = System.nanoTime();
        for (int i = 0; i < n; i++)
            sb.append("hello");
        long et = System.nanoTime();
        System.out.println("StringBuilder time: " + (et - st));
    }

    public static void main(String[] args) {
        int n = 1_000_000;

        testBuffer(n);
        testBuilder(n);
    }
}
