package com.in28minutes.unittesting.unittesting.Business;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void sizeBasic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters() {
        when(mock.get(0)).thenReturn("in28minutes");
        assertEquals("in28minutes", mock.get(0));
        assertEquals(null, mock.get(1));
    }

    @Test
    public void returnWithGenereicParameters() {
        when(mock.get(anyInt())).thenReturn("in28minutes");
        assertEquals("in28minutes", mock.get(0));
        assertEquals("in28minutes", mock.get(1));
    }

    @Test
    public void verificationBasics() {
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapturing() {
        mock.add("SomeString");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("SomeString",captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        mock.add("SomeString");
        mock.add("SomeString1");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();
        assertEquals("SomeString",allValues.get(0));
        assertEquals("SomeString1",allValues.get(1));
    }
}
