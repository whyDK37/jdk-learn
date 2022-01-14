package sound;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.SocketException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

/**
 * 声音录制的工具类
 *
 * @author suren
 * @date 2015年8月23日 上午8:58:34
 */
public class RecordUtil {

  private boolean done = false;
  private ByteArrayOutputStream bufStream = new ByteArrayOutputStream();
  private TargetDataLine dataLine;

  public static void main(String[] args) throws LineUnavailableException, SocketException {
    RecordUtil recordUtil = new RecordUtil();
    recordUtil.init();
    recordUtil.start();

  }

  public void start() {
    System.out.println("start record");

    try {
      init();

      int len = 1024;
      byte[] buf = new byte[len];
      while (!done && (len = dataLine.read(buf, 0, 1024)) != -1) {
        bufStream.write(buf, 0, len);
      }
    } catch (LineUnavailableException e) {
      e.printStackTrace();
    } catch (SocketException e) {
      e.printStackTrace();
    }
  }

  /**
   *
   */
  public void init() throws LineUnavailableException, SocketException {
    if (dataLine == null) {
      dataLine = AudioSystem.getTargetDataLine(null);

      dataLine.open();
      dataLine.start();
    }

    done = false;
  }

  public byte[] getData() {
    byte[] data = bufStream.toByteArray();
    bufStream.reset();

    return data;
  }

  public void finish() throws IOException {
    done = true;

    if (getData() == null) {
      return;
    }
  }

  public void close() {
    if (dataLine != null && dataLine.isOpen()) {
      dataLine.close();
    }
  }
}