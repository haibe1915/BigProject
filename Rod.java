/**
 * This class represents the Rod with disks on top. It involves
 * @author EFE ACER
 * @version 1.0
 */
package allAlgo;
import java.util.Stack;

public class Rod {
    private static final int  DISK_CAPACITY = 6;
    
    private Stack<Disk> disksOnTop;
    public Rod() {
        disksOnTop = new Stack<Disk>();
    }
    
    public Rod(int numberOfDisks) {
        disksOnTop = new Stack<Disk>();
        for (int i = 0; i < numberOfDisks; i++) {
            disksOnTop.push(new Disk(DISK_CAPACITY - i));
        }
    }
    
    public Stack<Disk> getDisksOnTop() {
        return disksOnTop;
    }
}