package IMUHERO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class readGraph  {
    Scanner scanner;
    public readGraph(Graph graph,String fileName){
        readFile(fileName);
        try{
            int V = scanner.nextInt();
            if (V < 0)
                throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
            assert V == graph.nodeSize();

            int E = scanner.nextInt();
            if (E < 0)
                throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
            for (int i = 0; i < E; i++) {
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                assert v >= 0 && v < V;
                assert w >= 0 && w < V;
                graph.addEdge(v, w);
        }

    }catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from input stream, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attemps to read an 'int' value from input stream, but there are no more tokens available");
        }
    }

    public void readFile(String fileName){
        assert fileName!=null;
        try {
            File file = new File(fileName);
            if (file.exists()) {
                FileInputStream fi = new FileInputStream(file);
                scanner=new Scanner(new BufferedInputStream(fi));
                scanner.useLocale(Locale.ENGLISH);
            }
        }
        catch (IOException ioe){
            throw new IllegalArgumentException("Could not oped"+fileName);
        }
    }
}
