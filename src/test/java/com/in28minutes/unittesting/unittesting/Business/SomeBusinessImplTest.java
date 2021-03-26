package com.in28minutes.unittesting.unittesting.Business;

import com.in28minutes.unittesting.unittesting.Data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SomeBusinessImplTest {

    @Test
    public void calculateSum_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {1,2,3});
        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);
    }

    class SomeDataServiceStub implements SomeDataService {
        @Override
        public int[] retrieveAllData() {
            return new int[] {1,2,3};
        }
    }
    @Test
    public void calculateSumUsingDataService_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService2_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();

        SomeDataService dataServiceMock = mock(SomeDataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});

        business.setSomeDataService(dataServiceMock);

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);
    }

}