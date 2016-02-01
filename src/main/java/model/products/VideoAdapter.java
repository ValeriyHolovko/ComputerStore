package model.products;

import model.ProductEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by 1 on 01.02.2016.
 */
@Entity
@Table(name = "video_adapters")
public class VideoAdapter extends ProductEntity{

    @Column
    private int memory;
    @Column
    private VideoAdapterChipsetType videoAdapterChipsetType;

    public VideoAdapter() {
    }

    public VideoAdapter(String brand, String model, double price, int memory, VideoAdapterChipsetType videoAdapterChipsetType) {
        super(ProductType.VideoAdapter, brand, model, price);
        this.memory = memory;
        this.videoAdapterChipsetType = videoAdapterChipsetType;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public VideoAdapterChipsetType getVideoAdapterChipsetType() {
        return videoAdapterChipsetType;
    }

    public void setVideoAdapterChipsetType(VideoAdapterChipsetType videoAdapterChipsetType) {
        this.videoAdapterChipsetType = videoAdapterChipsetType;
    }

    private enum VideoAdapterChipsetType {
        AMD_RADEON,NVIDIA_GEFORCE
    }
}
