package ca.jrvs.apps.grep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaGrepLambdaImp extends JavaGrepImp{

    private static final Logger logger = LoggerFactory.getLogger(JavaGrepLambdaImp.class);

    public static void main(String[] args) {
        if (args.length != 3)
            throw new IllegalArgumentException("Usage: regex rootDir outfile");

        JavaGrepLambdaImp jgLambda = new JavaGrepLambdaImp();
        jgLambda.setRegex(args[0]);
        jgLambda.setRootPath(args[1]);
        jgLambda.setOutFile(args[2]);

        try {
            jgLambda.process();
        } catch (Exception ex){
            logger.error(ex.getMessage());
        }
    }

    /**
     * Read a file using lambdas - overrides JavaGrep read lines
     * @param inputFile - user given file to read
     * @return - list of strings
     */
    @Override
    public List<String> readLines(File inputFile) {
        List<String> lines = new ArrayList<>();
        try{
            lines = Files.lines(inputFile.toPath()).collect(Collectors.toList());
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
        return lines;
    }

    @Override
    public List<File> listFiles (String rootDir){
        List<File> files = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Paths.get(rootDir))) {
            files = walk.filter(Files::isRegularFile).map(Path::toFile).collect(Collectors.toList());

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return files;
    }



}
