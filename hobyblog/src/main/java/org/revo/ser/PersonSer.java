/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.revo.ser;

import org.revo.entity.Person;

/**
 * 
 * @author revo
 */
public interface PersonSer extends GenericSer<Person> {

	public Person GetByEmail(String Email);

}
