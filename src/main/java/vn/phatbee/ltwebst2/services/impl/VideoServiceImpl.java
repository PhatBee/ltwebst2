package vn.phatbee.ltwebst2.services.impl;

import vn.phatbee.ltwebst2.dao.IVideoDao;
import vn.phatbee.ltwebst2.dao.impl.VideoDaoImpl;
import vn.phatbee.ltwebst2.entity.Video;
import vn.phatbee.ltwebst2.services.IVideoService;

import java.util.List;

public class VideoServiceImpl implements IVideoService {
    IVideoDao vidService = new VideoDaoImpl();
    @Override
    public void insert(Video video) {
        vidService.insert(video);
    }

    @Override
    public void update(Video video) {
        vidService.update(video);
    }

    @Override
    public void delete(int videoid) throws Exception {
        vidService.delete(videoid);
    }

    @Override
    public Video findById(int id) {
        return vidService.findById(id);
    }

    @Override
    public List<Video> findAll() {
        return vidService.findAll();
    }

    @Override
    public List<Video> findByTitle(String vidName) {
        return vidService.findByTitle(vidName);
    }

    @Override
    public List<Video> findAll(int page, int size) {
        return vidService.findAll(page, size);
    }

    @Override
    public int count() {
        return vidService.count();
    }
}
