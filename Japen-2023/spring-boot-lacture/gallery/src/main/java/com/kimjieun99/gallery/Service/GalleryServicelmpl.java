package com.kimjieun99.gallery.Service;

import com.kimjieun99.gallery.dao.GalleryDao;
import com.kimjieun99.gallery.dto.GalleryDto;
import com.kimjieun99.gallery.dto.ReplyDto;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GalleryServicelmpl implements GalleryService {

  @Autowired
  GalleryDao galleryDao;

  @Value("${file.path}")
  private String uploadFolder;

  @Override
  public int insertGallery(GalleryDto galleryDto) {
    UUID uuid = UUID.randomUUID();
    String originalFile = galleryDto.getFile().getOriginalFilename();
    String renamedFile = uuid + "_" + originalFile;
    galleryDto.setOriginal(originalFile);
    galleryDto.setRenamed(renamedFile);

    Path imgFilePath = Paths.get(uploadFolder + renamedFile);

    try {
      Files.write(imgFilePath, galleryDto.getFile().getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
    //try/catch

    int result = galleryDao.insertGallery(galleryDto);
    return result;
  }

  @Override
  public List<GalleryDto> getAllList() {
    List<GalleryDto> galleryList = galleryDao.getAllList();
    return galleryList;
  }

  @Override
  public GalleryDto viewGallery(int no) {
    GalleryDto galleryDto = galleryDao.viewGallery(no);
    return galleryDto;
  }

  @Override
  public int insertReply(ReplyDto replyDto) {
    int result = galleryDao.insertReply(replyDto);
    return result;
  }

  @Override
  public List<ReplyDto> getAllReply(int galleryId) {
    List<ReplyDto> replyList = galleryDao.getAllReply(galleryId);
    return replyList;
  }
}
