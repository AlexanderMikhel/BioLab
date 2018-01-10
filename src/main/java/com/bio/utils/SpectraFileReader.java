package com.bio.utils;

import com.bio.domain.Point;
import com.bio.domain.Spectra;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mikhel Alexander on 24.12.2017 email mikhelas@altarix.ru .
 */

@Component
public class SpectraFileReader {

    public List<File> multipartToFile(List<MultipartFile> multipartFiles) throws IllegalStateException, IOException {

        List<File> fileList = new ArrayList<>();
        for (MultipartFile mf : multipartFiles) {
            File convFile = new File(mf.getOriginalFilename());
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(mf.getBytes());
            fos.close();
            fileList.add(convFile);
        }

        return fileList;

    }

    public List<Spectra> readFromFile(List<File> files,Long profileId) throws IOException {
        List<Spectra> spectras = new ArrayList<>();
        for (File file : files) {
            Scanner in = new Scanner(new FileReader(file.getName()));
            Spectra spectra = new Spectra();
            List<String> s = new ArrayList<>();
            while (in.hasNextLine()) {
                s.add(in.next());
            }
            for (int i = 0; i < s.size(); i++) {
                Point p = new Point(Double.valueOf(s.get(i)),Double.valueOf(s.get(i)));
                spectra.getPoints().add(p);
            }

            spectra.setName(file.getName());
            spectras.add(spectra);
        }
        return spectras;
    }
}
