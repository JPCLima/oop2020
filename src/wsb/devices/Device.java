package wsb.devices;

import wsb.Mapped;

public abstract class Device {
    @Mapped
    final public String producer;
    @Mapped
    final public String model;
    @Mapped
    public Double value;


    public Device(String producer, String model) {
        this.producer = producer;
        this.model = model;
    }

    public String getModel(){
        return this.model;
    }

}
