/*
 * Java assignment 2 - JAC444
 * @author: Lawrence Reyes
 * @student number: 108307158 
 */
import java.util.Vector;

public class Lab implements MaxTagValue{
	public String labName; // lab name
	public Vector<MobileDevice> devices; // data structure that keeps all devices
	
	/*
	 * @constructor
	 */
	public Lab(String labName) {
        this.labName = labName;
        devices = new Vector<MobileDevice>();
    }

	/*
	 * Adds device to the devices vector
	 * @param MobileDevice
	 */
    public void addDevice(MobileDevice md) {
    		devices.add(md);
    }
	
    /*
     * Return the highest valueTag out of all device from an specific lab
     * @return maxValueTag
     */
	public int findMaximumValueTag() {
		int maxValueTag = devices.get(0).valueTag;
		
		for(int i = 0; i < devices.size(); i++){
			if(devices.get(i).valueTag > maxValueTag){
				maxValueTag = devices.get(i).valueTag;
			}	
		}
		return maxValueTag;
	}

	/*
	 * Checks for a particular device through all devices
	 * @param MobileDevice
	 * @return if it is foud or not
	 */
    public boolean isThereDevice(MobileDevice md) {
        boolean found = false;
        for(MobileDevice dev : devices){
        	if(dev.equals(md))
        		found = true;
        }   	
        return found;
    }
    
    /*
     * Function sends a rent request
     * @param wanted - MobileDevice wanted
     * @param requestRequest - date when the device is requested
     * @param dueDate - the date the device is due
     * @return true if device is rented
     * @return false if device is not rented
     */
  	public boolean rentRequest(MobileDevice wanted, String requestDate, String dueDate){
  		boolean available = false;
		try {
			if(Helper.isValidDate(requestDate) && Helper.isValidDate(dueDate)){
				if(Helper.timeDifference(requestDate, dueDate) > 0){
					if(wanted.rentDevice(requestDate, dueDate, this)){
						available = true;
					}else
						System.out.println(Helper.printUnavailable(wanted, requestDate));
				}else
					throw new DateFormatException("Wrong format for the date.");
			}
		} catch (DateFormatException e) {
			e.printStackTrace();
		}
  		return available;
  	}
  	
  	/*
  	 * @equals
  	 * @toString
  	 * @hashCode
  	 */
	@Override
    public boolean equals(Object o) {
    	if(this == o)
			return true;
		if(o == null)
			return false;
		if(!(o instanceof Lab))
			return false;
		return ((Lab)o).labName.equals(labName);
    }
	
    @Override
    public String toString() {
        String r = "";
        for(MobileDevice device : devices)
        	r +=  "(" + device.deviceName + ", " + device.valueTag + " => " + labName + ")\n";
        return r;
    }
    
    @Override
    public int hashCode() {
        int result = labName != null ? labName.hashCode() : 0;
        result = 31 * result + (devices != null ? devices.hashCode() : 0);
        return result;
    }
}
