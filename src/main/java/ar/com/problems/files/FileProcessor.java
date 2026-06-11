package ar.com.problems.files;

import java.util.List;

@FunctionalInterface
public interface FileProcessor {

    List<WordCount> process(String fileName);

}
