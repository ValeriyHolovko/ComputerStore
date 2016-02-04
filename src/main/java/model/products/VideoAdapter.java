package model.products;

import model.ProductEntity;

import javax.persistence.*;

/**
 * Created by 1 on 01.02.2016.
 */
@Entity
@Table(name = "video_adapters")
@DiscriminatorValue("VIDEO_ADAPTER")
public class VideoAdapter extends ProductEntity{

    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private int memory;
    @Column
    @Enumerated(EnumType.STRING)
    private VideoAdapterChipsetType videoAdapterChipsetType;

    public VideoAdapter() {
    }

    public VideoAdapter(String brand, String model, int memory, VideoAdapterChipsetType videoAdapterChipsetType) {
        this.brand = brand;
        this.model = model;
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
