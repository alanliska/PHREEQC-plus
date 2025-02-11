package cz.p;

public class MolCanvas_object {
    private int AtomNumber1;
    private String AtomSymbol1;
    private int AtomColor1, AtomBorderColor1;
    private float AtomRadius1_Ang, AtomRadius1_pix;
    private long TouchTime;
    private float Atom1X_Ang, Atom1Y_Ang, Atom1Z_Ang, Atom1X_pix, Atom1Y_pix;
    private int AtomNumber2;
    private String AtomSymbol2;
    private int AtomColor2;
    private float Atom2X_Ang, Atom2Y_Ang, Atom2Z_Ang, Atom2X_pix, Atom2Y_pix;
    private float Atom12X_Ang, Atom12Y_Ang, Atom12Z_Ang, Atom12X_pix, Atom12Y_pix;
    private float Dist2D_pix;
    // 1=atoms+borders, 2=H-bonds, 3=bonds, 4=text
    private int ObjectType;

    public MolCanvas_object(int AtomNumber1,String AtomSymbol1,int AtomColor1,int AtomBorderColor1,float AtomRadius1_Ang,float AtomRadius1_pix,long TouchTime,float Atom1X_Ang,float Atom1Y_Ang,float Atom1Z_Ang,float Atom1X_pix,float Atom1Y_pix,int AtomNumber2,String AtomSymbol2,int AtomColor2,float Atom2X_Ang,float Atom2Y_Ang,float Atom2Z_Ang,float Atom2X_pix,float Atom2Y_pix,float Atom12X_Ang,float Atom12Y_Ang,float Atom12Z_Ang,float Atom12X_pix,float Atom12Y_pix,float Dist2D_pix, int ObjectType){
        this.AtomNumber1 = AtomNumber1;
        this.AtomSymbol1 = AtomSymbol1;
        this.AtomColor1 = AtomColor1;
        this.AtomBorderColor1 = AtomBorderColor1;
        this.AtomRadius1_Ang = AtomRadius1_Ang;
        this.AtomRadius1_pix = AtomRadius1_pix;
        this.TouchTime = TouchTime;
        this.Atom1X_Ang = Atom1X_Ang;
        this.Atom1Y_Ang = Atom1Y_Ang;
        this.Atom1Z_Ang = Atom1Z_Ang;
        this.Atom1X_pix = Atom1X_pix;
        this.Atom1Y_pix = Atom1Y_pix;
        this.AtomNumber2 = AtomNumber2;
        this.AtomSymbol2 = AtomSymbol2;
        this.AtomColor2 = AtomColor2;
        this.Atom2X_Ang = Atom2X_Ang;
        this.Atom2Y_Ang = Atom2Y_Ang;
        this.Atom2Z_Ang = Atom2Z_Ang;
        this.Atom2X_pix = Atom2X_pix;
        this.Atom2Y_pix = Atom2Y_pix;
        this.Atom12X_Ang = Atom12X_Ang;
        this.Atom12Y_Ang = Atom12Y_Ang;
        this.Atom12Z_Ang = Atom12Z_Ang;
        this.Atom12X_pix = Atom12X_pix;
        this.Atom12Y_pix = Atom12Y_pix;
        this.Dist2D_pix = Dist2D_pix;
        this.ObjectType = ObjectType;
    }

    public int getAtomNumber1(){
        return AtomNumber1;
    }
    public void setAtomNumber1(int AtomNumber1){
        this.AtomNumber1 = AtomNumber1;
    }
    public String getAtomSymbol1(){
        return AtomSymbol1;
    }
    public void setAtomSymbol1(String AtomSymbol1){
        this.AtomSymbol1 = AtomSymbol1;
    }
    public int getAtomColor1(){
        return AtomColor1;
    }
    public void setAtomColor1(int AtomColor1){
        this.AtomColor1 = AtomColor1;
    }
    public int getAtomBorderColor1(){
        return AtomBorderColor1;
    }
    public void setAtomBorderColor1(int AtomBorderColor1){
        this.AtomBorderColor1 = AtomBorderColor1;
    }
    public float getAtomRadius1_Ang(){
        return AtomRadius1_Ang;
    }
    public void setAtomRadius1_Ang(float AtomRadius1_Ang){
        this.AtomRadius1_Ang = AtomRadius1_Ang;
    }
    public float getAtomRadius1_pix(){
        return AtomRadius1_pix;
    }
    public void setAtomRadius1_pix(float AtomRadius1_pix){
        this.AtomRadius1_pix = AtomRadius1_pix;
    }
    public long getTouchTime(){
        return TouchTime;
    }
    public void setTouchTime(long TouchTime){
        this.TouchTime = TouchTime;
    }
    public float getAtom1X_Ang(){
        return Atom1X_Ang;
    }
    public void setAtom1X_Ang(float Atom1X_Ang){
        this.Atom1X_Ang = Atom1X_Ang;
    }
    public float getAtom1Y_Ang(){
        return Atom1Y_Ang;
    }
    public void setAtom1Y_Ang(float Atom1Y_Ang){
        this.Atom1Y_Ang = Atom1Y_Ang;
    }
    public float getAtom1Z_Ang(){
        return Atom1Z_Ang;
    }
    public void setAtom1Z_Ang(float Atom1Z_Ang){
        this.Atom1Z_Ang = Atom1Z_Ang;
    }
    public float getAtom1X_pix(){
        return Atom1X_pix;
    }
    public void setAtom1X_pix(float Atom1X_pix){
        this.Atom1X_pix = Atom1X_pix;
    }
    public float getAtom1Y_pix(){
        return Atom1Y_pix;
    }
    public void setAtom1Y_pix(float Atom1Y_pix){
        this.Atom1Y_pix = Atom1Y_pix;
    }
    public int getAtomNumber2(){
        return AtomNumber2;
    }
    public void setAtomNumber2(int AtomNumber2){
        this.AtomNumber2 = AtomNumber2;
    }
    public String getAtomSymbol2(){
        return AtomSymbol2;
    }
    public void setAtomSymbol2(String AtomSymbol2){
        this.AtomSymbol2 = AtomSymbol2;
    }
    public int getAtomColor2(){
        return AtomColor2;
    }
    public void setAtomColor2(int AtomColor2){
        this.AtomColor2 = AtomColor2;
    }
    public float getAtom2X_Ang(){
        return Atom2X_Ang;
    }
    public void setAtom2X_Ang(float Atom2X_Ang){
        this.Atom2X_Ang = Atom2X_Ang;
    }
    public float getAtom2Y_Ang(){
        return Atom2Y_Ang;
    }
    public void setAtom2Y_Ang(float Atom2Y_Ang){
        this.Atom2Y_Ang = Atom2Y_Ang;
    }
    public float getAtom2Z_Ang(){
        return Atom2Z_Ang;
    }
    public void setAtom2Z_Ang(float Atom2Z_Ang){
        this.Atom2Z_Ang = Atom2Z_Ang;
    }
    public float getAtom2X_pix(){
        return Atom2X_pix;
    }
    public void setAtom2X_pix(float Atom2X_pix){
        this.Atom2X_pix = Atom2X_pix;
    }
    public float getAtom2Y_pix(){
        return Atom2Y_pix;
    }
    public void setAtom2Y_pix(float Atom2Y_pix){
        this.Atom2Y_pix = Atom2Y_pix;
    }
    public float getAtom12X_Ang(){
        return Atom12X_Ang;
    }
    public void setAtom12X_Ang(float Atom12X_Ang){
        this.Atom12X_Ang = Atom12X_Ang;
    }
    public float getAtom12Y_Ang(){
        return Atom12Y_Ang;
    }
    public void setAtom12Y_Ang(float Atom12Y_Ang){
        this.Atom12Y_Ang = Atom12Y_Ang;
    }
    public float getAtom12Z_Ang(){
        return Atom12Z_Ang;
    }
    public void setAtom12Z_Ang(float Atom12Z_Ang){
        this.Atom12Z_Ang = Atom12Z_Ang;
    }
    public float getAtom12X_pix(){
        return Atom12X_pix;
    }
    public void setAtom12X_pix(float Atom12X_pix){
        this.Atom12X_pix = Atom12X_pix;
    }
    public float getAtom12Y_pix(){
        return Atom12Y_pix;
    }
    public void setAtom12Y_pix(float Atom12Y_pix){
        this.Atom12Y_pix = Atom12Y_pix;
    }
    public float getDist2D_pix(){
        return Dist2D_pix;
    }
    public void setDist2D_pix(float Dist2D_pix){
        this.Dist2D_pix = Dist2D_pix;
    }
    public int getObjectType(){
        return ObjectType;
    }
    public void setObjectType(int ObjectType){
        this.ObjectType = ObjectType;
    }
}
