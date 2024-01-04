package bitcamp.io;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedDataInputStream extends DataInputStream {

  int size; // 버퍼에 읽어들인 개수
  int cursor; // 버퍼에서 꺼낸 순서
  private byte[] buffer = new byte[8192];

  public BufferedDataInputStream(String name) throws FileNotFoundException {
    super(name);
  }

  @Override
  public int read() throws IOException {
    if (size == cursor) {
      cursor = 0;
      size = super.read(buffer);
      if (size == -1) {
        return -1;
      }
    }
    return buffer[cursor++] & 0x000000ff;
    // 주의!
    // 바이트 값으로 봤을 때 음수일 경우, int로 리턴할 때도 음수가 된다.
    // 이를 방지하기 위해 앞 3바이트를 0으로 처리하여 양수화시킨다.
  }

  @Override
  public int read(byte[] arr) throws IOException {
    return read(arr, 0, arr.length);
  }
  @Override
  public int read(byte[] arr, int off, int len) throws IOException {
    // 배열 호출, 배열의 0번째가 아닌 off번째(지정 위치)부터 담을 것
    for (int i =off, count = 0; count<len; i++, count++){
      int b = read();
      if(b == -1){
        return count > 0 ? count : -1; // 현재까지 읽은 것 리턴
      }
      arr[i] = (byte) b;
    }
    return len;
  }
}
