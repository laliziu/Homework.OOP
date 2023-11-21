package model.save.base;

import model.save.Writable;

import java.io.*;

public class FileHandler implements Writable {
    @Override
    public  boolean save(Serializable serializable){
        String filePath = "src/model/save/base/tree.out";
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(serializable);
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
@Override
    public  Object read(){
    String filePath = "src/model/save/base/tree.out";
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return objectInputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}


