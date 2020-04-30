package app;

import app.ArrayCopy.Endian;

public class App {

  public static void main(String[] args) throws Exception {

    final int BYTE_ARRAY_SIZE = 16;

    byte[] inByteArray;
    byte[] outByteArray;

    inByteArray = new byte[BYTE_ARRAY_SIZE];
    outByteArray = new byte[BYTE_ARRAY_SIZE];
    short[] shortArray = new short[BYTE_ARRAY_SIZE / Short.BYTES];
    int[] IntArray = new int[BYTE_ARRAY_SIZE / Integer.BYTES];

    ArrayCopy arrayCopy = new ArrayCopy();

    for(int i=0; i<BYTE_ARRAY_SIZE; i++){
        inByteArray[i] = (byte)i;
    }

    System.out.println( String.format("Byte => short => Byte, Big Endian") );
    arrayCopy.copyArrayFromByte(inByteArray, shortArray);
    arrayCopy.copyArrayToByte(shortArray, outByteArray);
    for(int i=0; i<BYTE_ARRAY_SIZE; i++){
        System.out.println( String.format("in = %x, out = %x", inByteArray[i], outByteArray[i]) );
    }

    System.out.println( String.format("Byte => short => Byte, Little Endian") );
    arrayCopy.setEndian(Endian.LITTLE_ENDIAN);
    arrayCopy.copyArrayFromByte(inByteArray, shortArray);
    arrayCopy.copyArrayToByte(shortArray, outByteArray);
    for(int i=0; i<BYTE_ARRAY_SIZE; i++){
        System.out.println( String.format("in = %x, out = %x", inByteArray[i], outByteArray[i]) );
    }

    System.out.println( String.format("Byte => Int => Byte, Big Endian") );
    arrayCopy.setEndian(Endian.BIG_ENDIAN);
    arrayCopy.copyArrayFromByte(inByteArray, IntArray);
    arrayCopy.copyArrayToByte(IntArray, outByteArray);
    for(int i=0; i<BYTE_ARRAY_SIZE; i++){
        System.out.println( String.format("in = %x, out = %x", inByteArray[i], outByteArray[i]) );
    }

    System.out.println( String.format("Byte => Int => Byte, Little Endian") );
    arrayCopy.setEndian(Endian.LITTLE_ENDIAN);
    arrayCopy.copyArrayFromByte(inByteArray, IntArray);
    arrayCopy.copyArrayToByte(IntArray, outByteArray);
    for(int i=0; i<BYTE_ARRAY_SIZE; i++){
        System.out.println( String.format("in = %x, out = %x", inByteArray[i], outByteArray[i]) );
    }
  }
}