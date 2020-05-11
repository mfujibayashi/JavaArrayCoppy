package app;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ArrayCopy {
  private Endian isEndian;

  public enum Endian{
    BIG_ENDIAN,
    LITTLE_ENDIAN,
  }

  ArrayCopy(Endian endian){
    isEndian = endian;
  }

  ArrayCopy(){
    this(Endian.BIG_ENDIAN);
  }

  public void setEndian(Endian endian){
    isEndian = endian;
  }

  public Endian getEndian(){
    return isEndian;
  }

  public  void copyArrayFromByte(byte[] byteArray, int[] intArray){
    int length = intArray.length;
    int i;

    ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES*length);
    if(isEndian == Endian.BIG_ENDIAN){
        buffer.order(ByteOrder.BIG_ENDIAN);
    }else{
        buffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    for(i=0; i< length*Integer.BYTES; i++){
      buffer.put(byteArray[i]);
    }
    buffer.flip();
    for(i=0; i< length; i++){
      intArray[i] =  buffer.getInt();
        System.out.println( String.format("copy Byte => Int data=%08x %02x %02x %02x %02x", intArray[i], byteArray[4*i], byteArray[4*i+1], byteArray[4*i+2], byteArray[4*i+3]));
    }
  }

  public  void copyArrayToByte(int[] intArray, byte[] byteArray){
    int length = intArray.length;
    int i;
    ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES*length);

    if(isEndian == Endian.BIG_ENDIAN){
      buffer.order(ByteOrder.BIG_ENDIAN);
    }else{
        buffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    for(i=0; i< length; i++){
      buffer.putInt(intArray[i]);
    }
    buffer.flip();
    for(i=0; i< length*Integer.BYTES; i++){
      byteArray[i] = buffer.get();
    }

    for(i=0; i< length; i++){
      System.out.println( String.format("copy Int => Byte data=%08x %02x %02x %02x %02x", intArray[i], byteArray[4*i], byteArray[4*i+1], byteArray[4*i+2], byteArray[4*i+3]));
    }
  }

  public  void copyArrayFromByte(byte[] byteArray, short[] shortArray){
    int length = shortArray.length;
    int i;
    ByteBuffer buffer = ByteBuffer.allocate(Short.BYTES*length);

    if(isEndian == Endian.BIG_ENDIAN){
        buffer.order(ByteOrder.BIG_ENDIAN);
    }else{
        buffer.order(ByteOrder.LITTLE_ENDIAN);
    }
      
    for(i=0; i< length*Short.BYTES; i++){
        buffer.put(byteArray[i]);
    }
    buffer.flip();
    for(i=0; i< length; i++){
        shortArray[i] =  buffer.getShort();
        System.out.println( String.format("copy Byte => Short data=%04x %02x %02x", shortArray[i], byteArray[2*i], byteArray[2*i+1]));
    }
  }

  public  void copyArrayToByte(short[] shortArray, byte[] byteArray){
    int length = shortArray.length;
    int i;
    ByteBuffer buffer = ByteBuffer.allocate(Short.BYTES*length);

    if(isEndian == Endian.BIG_ENDIAN){
      buffer.order(ByteOrder.BIG_ENDIAN);
    }else{
        buffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    for(i=0; i< length; i++){
      buffer.putShort(shortArray[i]);
    }
    buffer.flip();
    for(i=0; i< length*Short.BYTES; i++){
      byteArray[i] = buffer.get();
    }

    for(i=0; i< length; i++){
      System.out.println( String.format("copy Short => Byte data=%04x %02x %02x", shortArray[i], byteArray[2*i], byteArray[2*i + 1]));
    }
  }
}