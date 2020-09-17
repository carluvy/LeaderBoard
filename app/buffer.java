public class Buffer {
    public static void main(String args[]) throws Exception {

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        // scan.close();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        // br.close();
        if (name != null) {
            System.out.println(num * 2 + "\n" + name);
        }

    }

}