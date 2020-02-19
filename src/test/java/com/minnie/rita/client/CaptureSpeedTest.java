package com.minnie.rita.client;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import com.minnie.rita.server.RemoteMessenger;
@RunWith(MockitoJUnitRunner.class)
public class CaptureSpeedTest
{
    @Mock
    RemoteMessenger messenger;

    @InjectMocks
    CaptureSpeed testSubject = new CaptureSpeed();

    @Test
    public void testFineWhenOverSpeeding(){
        when(messenger.isAvailable()).thenReturn(true);
        testSubject.checkOverSpeeding("x23-Jk2",31);
        verify(messenger,times(1)).issueFine(anyString());
    }

    @Test
    public void testDontFineWhenNotSpeeding(){
        when(messenger.isAvailable()).thenReturn(true);
        testSubject.checkOverSpeeding("x23-Jk2",29);
        verify(messenger,times(0)).issueFine(anyString());
    }

    @Test
    public void testIssueFineIsMocked(){
        when(messenger.isAvailable()).thenReturn(true);
        when(messenger.issueFine(anyString())).thenReturn("Issuing fine from mock");
        testSubject.checkOverSpeeding("x23-Jk2",31);
        verify(messenger,times(1)).issueFine(anyString());
    }
}
