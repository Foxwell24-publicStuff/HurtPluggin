package me.thefox.iivirtual;

public enum IIInfo
{
    Blindness,
    Temporary_Blindness,
    One_Legged,
    Legless,
    Broken_Leg,
    Missing_RightArm,
    Missing_LeftArm,
    Broken_RightArm,
    Broken_LeftArm,
    Broken_Back,
    Headache,
    Concussion,
    Maimed;

    public static IIInfo lookup(String id) {
        try {
            return IIInfo.valueOf(id);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
