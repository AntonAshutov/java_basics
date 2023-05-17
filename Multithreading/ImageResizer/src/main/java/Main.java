import java.io.File;

public class Main {
    public static int newWight = 300;

    public static void main(String[] args) {
        String srcFolder = "C:\\Users\\Igor\\Desktop\\foto";
        String dstFolder = "C:\\Users\\Igor\\Desktop\\fotoDst";

        File srcDir = new File(srcFolder);


        File[] files = srcDir.listFiles();
        int half = files.length / 2;
        int quarter = half / 2;
        File[] files1 = new File[quarter];
        File[] files2 = new File[half - quarter];
        File[] files3 = new File[quarter];
        File[] files4 = new File[files.length - (half + quarter)];

        System.arraycopy(files, 0, files1, 0, files1.length);
        System.arraycopy(files, quarter, files2, 0, files2.length);
        System.arraycopy(files, half, files3, 0, files3.length);
        System.arraycopy(files, (half + quarter), files4, 0, files4.length);

        long start = System.currentTimeMillis();

        Resizer resizer1 = new Resizer(files1, dstFolder, newWight, 1, start);
        Resizer resizer2 = new Resizer(files2, dstFolder, newWight, 2, start);
        Resizer resizer3 = new Resizer(files3, dstFolder, newWight, 3, start);
        Resizer resizer4 = new Resizer(files4, dstFolder, newWight, 4, start);

        resizer1.start();
        resizer2.start();
        resizer3.start();
        resizer4.start();
    }
}
