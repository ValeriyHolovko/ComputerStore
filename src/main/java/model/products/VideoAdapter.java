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
    private int memory;
    @Column
    @Enumerated(EnumType.STRING)
    private VideoAdapterChipsetType videoAdapterChipsetType;

    public VideoAdapter() {
    }

    public VideoAdapter(String brand, String model, int memory, VideoAdapterChipsetType videoAdapterChipsetType, double price) {
        super.brand = brand;
        super.model = model;
        super.price = price;
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

    public enum VideoAdapterChipsetType {
        AMD_RADEON,NVIDIA_GEFORCE
    }

    @Override
    public String toString() {
        return "VideoAdapter{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", memory=" + memory +
                ", videoAdapterChipsetType=" + videoAdapterChipsetType +
                '}';
    }
}
