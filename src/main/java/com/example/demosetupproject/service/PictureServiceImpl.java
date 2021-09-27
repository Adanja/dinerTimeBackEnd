package com.example.demosetupproject.service;

import org.springframework.util.StringUtils;
import com.example.demosetupproject.exceptions.RecordNotFoundException;
import com.example.demosetupproject.model.Picture;
import com.example.demosetupproject.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class PictureServiceImpl implements PictureService{
    private PictureRepository pictureRepository;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public Stream<Picture> getPictures() {
        return pictureRepository.findAll().stream();
    }

    @Override
    public Picture getPicture(Long id) {
        var optionalPicture = pictureRepository.findById(id);

        if(optionalPicture.isPresent()) {
            return optionalPicture.get();
        } else {
            throw new RecordNotFoundException("Picture does not exists");
        }
    }

    @Override
    public Picture getPictureByNameEquals(String name) {
        var picture = pictureRepository.findByNameEquals(name);

        return picture;
    }


    @Override
    public Picture storePicture(MultipartFile file) throws IOException {

        String filename = StringUtils.cleanPath(file.getOriginalFilename());

        Picture picture = new Picture(filename, file.getContentType(), file.getBytes());

        return pictureRepository.save(picture);

    }

    @Override
    public void deletePicture(Long id) {
        pictureRepository.deleteById(id);
    }
}
