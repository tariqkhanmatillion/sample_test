package com.minnie.rita.server;

public class RemoteMessenger
{
    public String issueFine(String registrationNumber)
    {
        return "Issuing fine for "+registrationNumber;
    }

    public boolean isAvailable()
    {
        return true;
    }
}
