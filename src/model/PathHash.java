package model;

import util.Validation;

public class PathHash {

    public Path createPath(String msg) {
        String pt = Validation.getString(msg);
        Path path = new Path(pt);
        return path;
    }

    public boolean checkPath(Path pt) {
        String pathCheck = pt.getPathFile();
        String[] arr = pathCheck.split("\\\\+");
        if (arr.length >= 2) {
            return true;
        } else {
            return false;
        }
    }

    public String findFileName(Path pt) {
        String pathCheck = pt.getPathFile();
        String[] arr = pathCheck.split("\\\\+");
        if (arr.length >= 2) {
            int dauCham = arr[arr.length - 1].indexOf('.');
            if (dauCham != -1) {      ////trường hợp có Extension
                String result = arr[arr.length - 1].substring(0, dauCham);
                return result;
            } else {    //trường hợp ko có Extension -> là folder
                return null;
            }
        } else {
            System.err.println("Path error!");
            return null;
        }
    }

    public String findExtension(Path pt) {
        String pathCheck = pt.getPathFile();
        String[] arr = pathCheck.split("\\\\+");
        if (arr.length >= 2) {
            int dauCham = arr[arr.length - 1].indexOf('.');
            if (dauCham != -1) {      ////trường hợp có Extension
                String result = arr[arr.length - 1].substring((dauCham + 1));
                return result;
            } else {    //trường hợp ko có Extension -> là folder
                return null;
            }
        } else {
            System.err.println("Path error!");
            return null;
        }
    }

    public String findDisk(Path pt) {
        String pathCheck = pt.getPathFile();
        String[] arr = pathCheck.split("\\\\+");
        if (arr.length >= 2) {
            return arr[0].substring(0, 1);
        } else {
            System.err.println("Path error!");
            return null;
        }
    }

    public String findPath(Path pt) {
        String pathCheck = pt.getPathFile();
        String[] arr = pathCheck.split("\\\\+");
        StringBuilder result = new StringBuilder();

        if (arr.length >= 2) {
            if (findFileName(pt) != null) {      //Path có chứa tên file
                for (int i = 0; i < arr.length - 1; i++) {        //Bỏ cuối
                    if(i==arr.length-2){
                        result.append(arr[i]);
                    } else { result.append(arr[i]).append("\\"); }
                }
            } else {                            //Path ko chứa tên file -> là folder
                for (int i = 0; i < arr.length; i++) {            //Ko bỏ gì cả
                    if(i==arr.length-1){
                        result.append(arr[i]);
                    } else { result.append(arr[i]).append("\\"); }
                }
            }
            return result.toString();
        } else {
            System.err.println("Path error!");
            return null;
        }
    }

    public String[] findFolders(Path pt) {
        String pathCheck = pt.getPathFile();
        String[] arr = pathCheck.split("\\\\+");
        String[] result;
        
        if (arr.length >= 2) {
            if (findFileName(pt) != null) {               //Path có chứa tên file
                result = new String[arr.length - 2];
                for (int i = 1; i < arr.length - 1; i++) {    //bỏ đầu và cuối
                    result[i - 1] = arr[i];                //thêm các folder vào result 
                }
            } else {                                    //Path ko chứa tên file -> chỉ có folder
                result = new String[arr.length - 1];
                for (int i = 1; i < arr.length; i++) {    //bỏ đầu
                    result[i - 1] = arr[i];                //thêm các folder vào result 
                }
            }
            return result;
        } else {
            System.err.println("Path error!");
            return null;
        }
    }

}
