package com.bloxbean.cardano.client.transaction.spec.script;

import co.nstant.in.cbor.model.Array;
import co.nstant.in.cbor.model.DataItem;
import co.nstant.in.cbor.model.UnsignedInteger;
import com.bloxbean.cardano.client.exception.CborDeserializationException;
import com.bloxbean.cardano.client.exception.CborSerializationException;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * This script class is for "RequireAllOf" expression
 */
@Data
public class ScriptAll implements NativeScript {
    private final static Logger LOG = LoggerFactory.getLogger(ScriptAll.class);

    private ScriptType type;
    private List<NativeScript> scripts;

    public ScriptAll() {
        this.type = ScriptType.all;
        this.scripts = new ArrayList<>();
    }

    public ScriptAll addScript(NativeScript script) {
        scripts.add(script);

        return  this;
    }

    //script_all = (1, [ * native_script ])
    @Override
    public DataItem serializeAsDataItem() throws CborSerializationException {
        Array array = new Array();
        array.add(new UnsignedInteger(1));

        Array scriptsArray = new Array();
        for(NativeScript script: scripts) {
            scriptsArray.add(script.serializeAsDataItem());
        }

        array.add(scriptsArray);
        return array;
    }

    public static ScriptAll deserialize(Array array) throws CborDeserializationException {
        ScriptAll scriptAll = new ScriptAll();
        Array scriptsDIArray = (Array)(array.getDataItems().get(1));
        for(DataItem scriptDI: scriptsDIArray.getDataItems()) {
            Array scriptArray = (Array)scriptDI;
            NativeScript nativeScript = NativeScript.deserialize(scriptArray);
            if(nativeScript != null)
                scriptAll.addScript(nativeScript);
        }

        return scriptAll;
    }
}
