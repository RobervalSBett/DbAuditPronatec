/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cortez.samples.javaee7angular.data;

import javax.persistence.Column;


public class AuditoriasImpl extends Auditorias {
    
    @Column(name = "IDCERT" )
    private Certificadoras certificadora ;  
    
}
