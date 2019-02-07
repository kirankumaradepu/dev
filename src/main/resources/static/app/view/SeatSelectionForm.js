function loadData(val, component) {
    switch (component.itemId) {
        case '1': return this.up().record.customerName;
        case '2': return this.up().record.seatNo;
        case '3': return this.up().record.ticketType;
        case '4': return this.up().record.confirmationNo;
        default :  return val;
    }
}

Ext.define('Seats', {
    extend: 'Ext.data.Model',
    fields: [{name: '', type: 'string'}]
});

var myStore = Ext.create('Ext.data.Store', {
    model: 'Seats',
    fields: ['seatNo'],
    proxy: {
        type: 'ajax',
        url: '/reservations/getSeats/1',
        reader: {
            type: 'json'
        }
    }
});
Ext.define('app.view.SeatSelectionForm', {
    extend: 'Ext.form.Panel',
    alias: 'widget.SeatSelectionForm',
    bodyPadding: 5,
    width: 350,
    layout: 'anchor',
    defaults: {
        anchor: '100%'
    },
    items: [{
        xtype: 'displayfield',
        fieldLabel: 'Customer Name',
        name: 'Customer Name',
        itemId: '1',
        renderer: loadData
    }, {
        xtype: 'combobox',
        fieldLabel: 'Seat No.',
        name: 'seatNo',
        itemId: '2',
        store: myStore,
        renderer: loadData,
        listeners: {
            afterrender: function (t, e, f) {
                debugger;
                myStore.load();
            },
            change:function (field,newValue,oldValue, eOpts) {
                this.findParentByType('SeatSelectionForm').record.seatNo = newValue;
            }
        }
    }, {
        xtype: 'displayfield',
        fieldLabel: 'Ticket Type',
        name: 'ticketType',
        itemId: '3',
        renderer: loadData
    }, {
        xtype: 'displayfield',
        fieldLabel: 'Confirmation No.',
        name: 'confirmationNo',
        itemId: '4',
        renderer: loadData
    }],
    buttons: [{
        text: 'Reset',
        handler: function () {
            this.up('form').getForm().reset();
        }
    }, {
        text: 'Submit',
        formBind: true, //only enabled once the form is valid
        disabled: true,
        handler: function () {
            var form = this.up('form').getForm();
            if (form.isValid()) {
                form.submit({
                    url: '/reservations/updateReservation',
                    params: Ext.JSON.encode(this.findParentByType('SeatSelectionForm').record),
                    success: function (form, action) {
                        Ext.Msg.alert('Success', action.result.msg);
                    },
                    failure: function (form, action) {
                        Ext.Msg.alert('Failed', action.result.msg);
                    }
                });
            }
        }
    }]
});