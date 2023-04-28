package com.kimjieun99.gallery.Service;

import com.kimjieun99.gallery.dto.GalleryDto;
import com.kimjieun99.gallery.dto.ReplyDto;
import java.util.List;

public interface GalleryService {
  int insertGallery(GalleryDto galleryDto);

  List<GalleryDto> getAllList();

  GalleryDto viewGallery(int no);

  int insertReply(ReplyDto replyDto);

  List<ReplyDto> getAllReply(int galleryId);
}
