package com.minnie.rita.client;

import com.google.inject.Inject;
import com.minnie.rita.server.RemoteMessenger;

public class CaptureSpeed
{
    @Inject
    private RemoteMessenger messenger;

    private static int MAX_LIMIT = 30;

    public boolean checkOverSpeeding(String registrationNumber, int speed){
        if(!messenger.isAvailable()){
            throw new RuntimeException("Messenger not available lucky driver");
        }
        else
        {
            if (speed > MAX_LIMIT)
            {
                System.out.println(messenger.issueFine(registrationNumber));
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
