/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gable.testapi.model;

import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.LDAPSearchException;
import com.unboundid.ldap.sdk.SearchResult;
import com.unboundid.ldap.sdk.SearchResultEntry;
import com.unboundid.ldap.sdk.SearchScope;
import java.util.List;
/**
 *
 * @author Admin
 */
public class LdapAuthen {
    public static LDAPConnection getConnection() throws LDAPException {
        // host, port, username and password
        return new LDAPConnection("192.168.202.214", 1389, "cn=Directory Manager", "Oracle@NHSO01");
    }
    public static List<SearchResultEntry> getResults(LDAPConnection connection, String baseDN, String filter) throws LDAPSearchException {
    SearchResult searchResult;

    if (connection.isConnected()) {
        searchResult = connection.search(baseDN, SearchScope.ONE, filter);

        return searchResult.getSearchEntries();
    }

    return null;
}
}
