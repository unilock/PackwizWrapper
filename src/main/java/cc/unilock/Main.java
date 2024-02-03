package cc.unilock;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main {
    public static final boolean WINDOWS = System.getProperty("os.name").toLowerCase(Locale.ROOT).startsWith("windows");

    // args[0] = "$INST_JAVA"
    // args[1] = "$INST_MC_DIR"
    // args[2] = "https://example.com/packwiz/<modpack_fabric>/pack.toml"
    // args[3] = "https://example.com/packwiz/<modpack_forge>/pack.toml"
    public static void main(String[] args) throws Exception {
        System.out.println("[INFO] Welcome to unilock's epic packwiz wrapper!");
        System.out.println("[INFO] We are "+(WINDOWS ? "" : "not ")+"on Windows nya~");

        runJavaCommand(args[0], args[1], args[2], "fabric", false);
        runJavaCommand(args[0], args[1], args[3], "forge", true);
    }

    private static void runJavaCommand(String java, String path, String url, String loader, boolean updateMMC) throws Exception {
        ProcessBuilder builder = new ProcessBuilder();
        builder.redirectErrorStream(true);
        String cmd = "'"+java+"' -jar packwiz-installer-bootstrap.jar --meta-file 'packwiz-"+loader+".json' "+(updateMMC ? "" : "--multimc-folder 'null' ")+"'"+url+"'";
        if (WINDOWS) {
            builder.command("cmd.exe", "/c", cmd);
        } else {
            builder.command("/bin/sh", "-c", cmd);
        }
        builder.directory(new File(path));

        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line;
        while (true) {
            line = r.readLine();
            if (line == null) break;
            System.out.println(line);
        }

        p.waitFor();

        if (p.exitValue() != 0) {
            System.exit(p.exitValue());
        }
    }
}