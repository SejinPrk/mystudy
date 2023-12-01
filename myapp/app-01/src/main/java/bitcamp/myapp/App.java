@Override
public int describeContents(){
    return 0;
    }

@Override
public void writeToParcel(@android.support.annotation.NonNull android.os.Parcel dest,int flags){

    }

public static final android.os.Parcelable.Creator<> CREATOR=new Parcelable.Creator<>(){
@Override
public  createFromParcel(Parcel in){
    return new(in);
    }

@Override
public []newArray(int size){
    return new[size];
    }
    };

public class App {

  public static void main(String[] args) {
  }

  static String prompt(Scanner keyIn) {
    System.out.print("메인> ");
    return keyIn.nextLine();
  }
}
