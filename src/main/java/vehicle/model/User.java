package vehicle.model;

public class User {
	protected int id;
	protected String name;
	protected String mobileNo;
	protected String address;
	protected String date;
	protected String vehicleNo;
	protected String vehicleType;

	public User() {
	}

	public User(String name, String mobileNo, String address, String date, String vehicleNo, String vehicleType) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.address = address;
		this.date = date;
		this.vehicleNo = vehicleNo;
		this.vehicleType = vehicleType;
	}

	public User(int id, String name, String mobileNo, String address, String date, String vehicleNo,
			String vehicleType) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.address = address;
		this.date = date;
		this.vehicleNo = vehicleNo;
		this.vehicleType = vehicleType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	
}
