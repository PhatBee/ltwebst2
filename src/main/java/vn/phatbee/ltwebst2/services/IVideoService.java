package vn.phatbee.ltwebst2.services;

import vn.phatbee.ltwebst2.entity.Video;

import java.util.List;

public interface IVideoService {
    void insert(Video video);
    void update(Video video);
    void delete(int videoid) throws Exception;
    Video findById(int id);
    List<Video> findAll();
    List<Video> findByTitle(String vidName);
    List<Video> findAll(int page, int size);
    int count();
}
