package applabs.nfcwriter;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.nfc.NfcAdapter;

/**
 * Created by amrendukumar on 29/04/18.
 */

public class NFCManager {
    private Activity activity;
    private NfcAdapter nfcAdpt;

    public NFCManager(Activity activity) {
        this.activity = activity;
    }

    public void verifyNFC() throws NFCNotSupported, NFCNotEnabled {

        nfcAdpt = NfcAdapter.getDefaultAdapter(activity);

        if (nfcAdpt == null)
            throw new NFCNotSupported("nfc not supported");

        if (!nfcAdpt.isEnabled())
            throw new NFCNotEnabled("nfc not enabled");

    }

    public class NFCNotSupported extends Exception{
        public NFCNotSupported(String s) {
            // Call constructor of parent Exception
            super(s);

        }
    }

    public class NFCNotEnabled extends Exception{
        public NFCNotEnabled(String s){
            super(s);
        }

    }
}
