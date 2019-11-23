package Application.User;

public class Device {

    private String deviceUuid;
    private String deviceType;

    public Device() { }

    public Device(String deviceUuid, String deviceType) {
        this.deviceUuid = deviceUuid;
        this.deviceType = deviceType;
    }

    public String getDeviceUuid() {
        return deviceUuid;
    }

    public void setDeviceUuid(String deviceUuid) {
        this.deviceUuid = deviceUuid;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}
