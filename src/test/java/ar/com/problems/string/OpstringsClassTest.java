package ar.com.problems.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class OpstringsClassTest extends BaseTest {

    @Test
    public void diag1Sym() {
        System.out.println("Fixed Tests diag1Sym");
        testing(Opstrings.oper(Opstrings::diag1Sym, "wuUyPC\neNHWxw\nehifmi\ntBTlFI\nvWNpdv\nIFkGjZ"),
                "weetvI\nuNhBWF\nUHiTNk\nyWflpG\nPxmFdj\nCwiIvZ");
    }

    @Test
    public void rot90Clock() {
        System.out.println("Fixed Tests rot90Clock");
        testing(Opstrings.oper(Opstrings::rot90Clock, "rgavce\nvGcEKl\ndChZVW\nxNWgXR\niJBYDO\nSdmEKb"),
                "Sixdvr\ndJNCGg\nmBWhca\nEYgZEv\nKDXVKc\nbORWle");
    }

    @Test
    public void selfieAndDiag1() {
        System.out.println("Fixed Tests selfieAndDiag1");
        testing(Opstrings.oper(Opstrings::selfieAndDiag1, "NJVGhr\nMObsvw\ntPhCtl\nsoEnhi\nrtQRLK\nzjliWg"),
                "NJVGhr|NMtsrz\nMObsvw|JOPotj\ntPhCtl|VbhEQl\nsoEnhi|GsCnRi\nrtQRLK|hvthLW\nzjliWg|rwliKg");
    }
}