package teacher.day20.service;

import java.util.List;

import teacher.day20.Word;

public interface FileService {

	List<Word> load(String fileName);

	boolean save(String fileName, List<Word> list);

}
