package com.ingeint.scaleconnector.service;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;


class ScaleConnectorTest {

    @Test
    void getValueForWhiteSpace() {
        ScaleConnector scaleConnector = new ScaleConnector("", 0,0,0,0);
        scaleConnector.setStartCharacter('+');
        scaleConnector.setEndCharacter(' ');
        scaleConnector.setStabilityValuePosition(0);
        scaleConnector.setStartCutPosition(1);
        scaleConnector.setEndCutPosition(8);
        scaleConnector.setFloatingPoint(2);

        String rowValue ="B0+0000155 Kg054B";
        Result value =  scaleConnector.getValue(rowValue);

        assertThat(value.getValue()).isEqualTo("1.55");
        assertThat(value.toDouble()).isEqualTo(1.55);
        assertThat(value.getStability()).isEqualTo("+");
    }

    @Test
    void getValueForAlphaChars() {
        ScaleConnector scaleConnector = new ScaleConnector("", 0,0,0,0);
        scaleConnector.setStartCharacter('+');
        scaleConnector.setEndCharacter('K');
        scaleConnector.setStabilityValuePosition(0);
        scaleConnector.setStartCutPosition(1);
        scaleConnector.setEndCutPosition(9);
        scaleConnector.setFloatingPoint(2);

        String rowValue ="B0+0000155 Kg054B";
        Result value =  scaleConnector.getValue(rowValue);

        assertThat(value.getValue()).isEqualTo("1.55");
        assertThat(value.toDouble()).isEqualTo(1.55);
        assertThat(value.getStability()).isEqualTo("+");
    }

    @Test
    void getValueForAlphaChars2() {
        ScaleConnector scaleConnector = new ScaleConnector("", 0,0,0,0);
        scaleConnector.setStartCharacter('+');
        scaleConnector.setEndCharacter('k');
        scaleConnector.setStabilityValuePosition(0);
        scaleConnector.setStartCutPosition(1);
        scaleConnector.setEndCutPosition(7);
        scaleConnector.setFloatingPoint(1);

        String rowValue ="ST,GS,+   10.5kg\nST,GS,+   10.5kg";
        Result value =  scaleConnector.getValue(rowValue);

        assertThat(value.getValue()).isEqualTo("10.5");
        assertThat(value.toDouble()).isEqualTo(10.5);
        assertThat(value.getStability()).isEqualTo("+");
    }

    @Test
    void getValueForAlphaChars3() {
        ScaleConnector scaleConnector = new ScaleConnector("", 0,0,0,0);
        scaleConnector.setStartCharacter('+');
        scaleConnector.setEndCharacter(' ');
        scaleConnector.setStabilityValuePosition(0);
        scaleConnector.setStartCutPosition(1);
        scaleConnector.setEndCutPosition(7);
        scaleConnector.setFloatingPoint(2);

        String rowValue ="Kg053A1+0000381 Kg053A1+0000381";
        Result value =  scaleConnector.getValue(rowValue);

        assertThat(value.getValue()).isEqualTo("3.81");
        assertThat(value.toDouble()).isEqualTo(3.81);
        assertThat(value.getStability()).isEqualTo("+");
    }

    @Test
    void getValueForStartCutting() {
        ScaleConnector scaleConnector = new ScaleConnector("", 0,0,0,0);
        scaleConnector.setStartCharacter('+');
        scaleConnector.setEndCharacter(' ');
        scaleConnector.setStabilityValuePosition(0);
        scaleConnector.setStartCutPosition(1);
        scaleConnector.setEndCutPosition(7);
        scaleConnector.setFloatingPoint(2);

        String rowValue ="Kg053A1+1000381 Kg053A1+1000381";
        Result value =  scaleConnector.getValue(rowValue);

        assertThat(value.getValue()).isEqualTo("10003.81");
        assertThat(value.toDouble()).isEqualTo(10003.81);
        assertThat(value.getStability()).isEqualTo("+");
    }
}