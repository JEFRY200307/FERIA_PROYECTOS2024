   <template>
      <v-container>
         <v-table>
            <tbody>
               <tr v-for="(question, index) in questions" :key="index">
                  <td class="font-weight-bold text-right">{{ question.text }}</td>
                  <td class="td-class">
                     <v-radio-group v-model="question.selectedOption" 
                     inline 
                     hide-details
                     class="d-flex justify-end"
                     >
                        <v-radio v-for="option in options" 
                        :key="option" 
                        :value="option" 
                        style="color: #8E344D;" 
                        class="mx-5"></v-radio>
                     </v-radio-group>
                  </td>
                  
               </tr>
            </tbody>
         </v-table>

         <v-btn class="mt-5" color="#8E344D">Enviar</v-btn>
      </v-container>
   </template>

   <style scoped>
   v-table tbody {
      align-items: center;
   }
   v-table{
      background-color: rgba(255, 255, 255, 0.8);
      /* align-items: center; */
   }
   </style>

   <script setup>
   import { ref } from 'vue';

   const options = [1, 2, 3, 4, 5, 6];

   const questions = ref([
      { text: 'Question 1', selectedOption: null },
      { text: 'Question 2', selectedOption: null },
      { text: 'Question 3', selectedOption: null },
      { text: 'Question 4', selectedOption: null },
      { text: 'Question 5', selectedOption: null },
      { text: 'Question 6', selectedOption: null },
      { text: 'Question 7', selectedOption: null },
      { text: 'Question 8', selectedOption: null },
      { text: 'Question 9', selectedOption: null },
      { text: 'Question 10', selectedOption: null },
      { text: 'Question 11', selectedOption: null },
      { text: 'Question 12', selectedOption: null },
   ]);
   </script>
