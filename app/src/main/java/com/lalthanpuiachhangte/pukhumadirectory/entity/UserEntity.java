package com.lalthanpuiachhangte.pukhumadirectory.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class UserEntity implements Parcelable {

    int serialNumber;
    String name;
    String address;
    String designation;
    String presentPosting;
    String dateOfBirth;
    String dateOfRetirement;
    ArrayList<String> phone;
    String grade;

    String extra1;  //extra1 = real column name
    String extra2;  //extra2 = real column name
    String extra3;  //extra3 = real column name
    String extra4;  //...
    String extra5;  //
    String extra6;  //
    String extra7;  //

    public UserEntity() {
    }

    public UserEntity(int serialNumber, String name, String address, String designation, String presentPosting, String dateOfBirth, String dateOfRetirement, ArrayList<String> phone, String grade, String extra1, String extra2, String extra3, String extra4, String extra5, String extra6, String extra7) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.address = address;
        this.designation = designation;
        this.presentPosting = presentPosting;
        this.dateOfBirth = dateOfBirth;
        this.dateOfRetirement = dateOfRetirement;
        this.phone = phone;
        this.grade = grade;
        this.extra1 = extra1;
        this.extra2 = extra2;
        this.extra3 = extra3;
        this.extra4 = extra4;
        this.extra5 = extra5;
        this.extra6 = extra6;
        this.extra7 = extra7;
    }

    protected UserEntity(Parcel in) {
        serialNumber = in.readInt();
        name = in.readString();
        address = in.readString();
        designation = in.readString();
        presentPosting = in.readString();
        dateOfBirth = in.readString();
        dateOfRetirement = in.readString();
        phone = in.createStringArrayList();
        grade = in.readString();
        extra1 = in.readString();
        extra2 = in.readString();
        extra3 = in.readString();
        extra4 = in.readString();
        extra5 = in.readString();
        extra6 = in.readString();
        extra7 = in.readString();
    }

    public static final Creator<UserEntity> CREATOR = new Creator<UserEntity>() {
        @Override
        public UserEntity createFromParcel(Parcel in) {
            return new UserEntity(in);
        }

        @Override
        public UserEntity[] newArray(int size) {
            return new UserEntity[size];
        }
    };

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPresentPosting() {
        return presentPosting;
    }

    public void setPresentPosting(String presentPosting) {
        this.presentPosting = presentPosting;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfRetirement() {
        return dateOfRetirement;
    }

    public void setDateOfRetirement(String dateOfRetirement) {
        this.dateOfRetirement = dateOfRetirement;
    }

    public ArrayList<String> getPhone() {
        return phone;
    }

    public void setPhone(ArrayList<String> phone) {
        this.phone = phone;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getExtra1() {
        return extra1;
    }

    public void setExtra1(String extra1) {
        this.extra1 = extra1;
    }

    public String getExtra2() {
        return extra2;
    }

    public void setExtra2(String extra2) {
        this.extra2 = extra2;
    }

    public String getExtra3() {
        return extra3;
    }

    public void setExtra3(String extra3) {
        this.extra3 = extra3;
    }

    public String getExtra4() {
        return extra4;
    }

    public void setExtra4(String extra4) {
        this.extra4 = extra4;
    }

    public String getExtra5() {
        return extra5;
    }

    public void setExtra5(String extra5) {
        this.extra5 = extra5;
    }

    public String getExtra6() {
        return extra6;
    }

    public void setExtra6(String extra6) {
        this.extra6 = extra6;
    }

    public String getExtra7() {
        return extra7;
    }

    public void setExtra7(String extra7) {
        this.extra7 = extra7;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(serialNumber);
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(designation);
        dest.writeString(presentPosting);
        dest.writeString(dateOfBirth);
        dest.writeString(dateOfRetirement);
        dest.writeStringList(phone);
        dest.writeString(grade);
        dest.writeString(extra1);
        dest.writeString(extra2);
        dest.writeString(extra3);
        dest.writeString(extra4);
        dest.writeString(extra5);
        dest.writeString(extra6);
        dest.writeString(extra7);
    }
}
