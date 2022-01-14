# Java Grep Application
# Introduction
The Java Grep Application implements a `grep` function for Java. The app recursively searches a files in a directory for a text match to some user given pattern. If any lines of text in the files match the user pattern, they are outputted to a file. This app uses Maven for project management and build. The project is developed using the Intellij IDE with a Java 1.8 SDK. Some of the methods of the interface are implemented using lambdas. SLF4j is imported for error logging. Finally, the app is deployed using docker.

# Quick Start
Both `JavaGrepImp.java` and `JavaGrepLambdaImp.java` contain `main` functions from which the app can be run. Both of these `main` functions require three user arguments:

- `regex`: the regular expression or pattern to search for
- `root_dir`: a root directory or file to search
- `outfile`: a file to output results to

Please note the fat jar created by Maven assumes the main class as the `JavaGrepImp.java` `main` function.

# Implementation
## Pseudocode

The `process` function is used as a high level workflow for the application.

```
process() {
    matchedLines = []
    for file in listFilesRecursively(rootDir)
        for line in readLines(file)
            if containsPattern(line)
                matchedLines.add(line)
    writeToFile(matchedLines)
}
```

## Performance Issue
Potential performance issues may be encountered if the size of the data the application is attempting to read is larger than the heap memory. This can result in a `java.lang.OutOfMemoryError`. This can be resolved by tuning the JVM to increase heap size when running the application.

# Test

The application was tested manually. As a test case regex patterns were run on files in the ./src directory. The outputted results were compared to expected results.

Example test case:
`java -jar grep-1.0-SNAPSHOT.jar ./src package.* grep_outfile.txt`

This should output all lines with the word "package" from all files in the ./src directory. The expected results are:

package ca.jrvs.apps.practice;
package ca.jrvs.apps.practice;
package ca.jrvs.apps.practice;

The outputted result matched the expected result.

# Deployment

A docker image containing all the contents of the maven package was created and pushed to Docker Hub. When the image is run, the command to run the JAR file is executed, the user only needs to provide the `regex`, `root_dir`, and `outfile` arguments.

The docker image for this application can be accessed via:
```docker pull bmaqsood/grep```

# Improvements

- File reading can be implemented using a stream to handle large files and avoid potential memory issues.
- Output can be expanded to include which file each line match was found in.
- A total count of the matches could be provided for a quick summary. 
